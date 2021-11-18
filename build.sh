eval $(minikube docker-env);
sh ./fraudes-service/build.sh;
sh ./payment-service/build.sh;
sh ./transacao-service/build.sh;
eval $(minikube docker-env -u);