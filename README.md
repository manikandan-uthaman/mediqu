# mediqu
Its a microservice based backend for a mock hospital dashboard project 

## Technologies
For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Kubernetes
To run this application follow the below steps:

Open all the pom files. In `spring-boot-maven-plugin` configuration section, replace `name` with `<your_docker-registry>/${project.artifactId}:${project.version}`.

Then open command prompt in the root folder and run 

```shell
sh build-image.sh
```

Once all the images are built, push the images to your docker registry.

Then open `kube-compose.yaml` file. In the comfig map section update the database details.
- spring.datasource.url
- spring.datasource.username

In your kubernetes cluster create a secret `db-secret` and the database password with the key `password`. 

Then, you can run the kube-compose file in your kubernetes cluster using the command

```shell
kubectl apply -f kube-compose.yaml
```