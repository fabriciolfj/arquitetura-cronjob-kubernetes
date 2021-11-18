path=$(pwd)/payment-service
echo $path
cd $path
mvn clean install
mvn spring-boot:build-image
docker push fabricio211/payment-service

minikube cache add fabricio211/payment-service