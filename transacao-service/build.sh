path=$(pwd)/transacao-service
echo $path
cd $path
mvn clean install
mvn spring-boot:build-image
docker push fabricio211/transacao-service

minikube cache add fabricio211/transacao-service