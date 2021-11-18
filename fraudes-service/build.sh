path=$(pwd)/fraudes-service
echo $path
cd $path
mvn clean install
mvn spring-boot:build-image
docker push fabricio211/fraude-service

minikube cache add fabricio211/fraude-service