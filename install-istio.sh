istioctl install --skip-confirmation \
 --set profile=demo \
 --set meshConfig.accessLogFile=/dev/stdout \
 --set meshConfig.accessLogEncoding=JSON

kubectl -n istio-system wait --timeout=600s --for=condition=available deployment --all

istio_version=$(istioctl version --short --remote=false)
echo "Installing integrations for Istio v$istio_version"
kubectl apply -n istio-system -f https://raw.githubusercontent.com/istio/istio/${istio_version}/samples/addons/kiali.yaml
kubectl apply -n istio-system -f https://raw.githubusercontent.com/istio/istio/${istio_version}/samples/addons/jaeger.yaml
kubectl apply -n istio-system -f https://raw.githubusercontent.com/istio/istio/${istio_version}/samples/addons/prometheus.yaml
kubectl apply -n istio-system -f https://raw.githubusercontent.com/istio/istio/${istio_version}/samples/addons/grafana.yaml


helm upgrade --install istio-microservices-on-addons kubernetes/helm/environments/istio-system -n istio-system --wait

kubectl get service istio-ingressgateway -o jsonpath='{.status.loadBalancer.ingress[0].ip}' --namespace=istio-system


kubectl -n istio-system create deployment mail-server --image maildev/maildev:1.1.0
kubectl -n istio-system expose deployment mail-server --port=80,25 --type=ClusterIP
kubectl -n istio-system wait --timeout=60s --for=condition=ready pod -l app=mail-server