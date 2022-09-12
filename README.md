# Intelligent Real Estate

Crearemos un sistema operativo que ayude al usuario a adminsitrar sus bienes reices, viendolo desde el lado del Arrendador y Arrendatario

## Como obtener el codigo

```shell
#Para usuarios que no sean propietarios o que no tengan configurado la ssh key
$ git clone git@github.com:KevyJQ/intelligent-realestate.git
$ cd intelligent-realestate
```
Si tienes configurado la llave ssh, utiliza este comando

```shell
#Para el propietario y tienes la llave ssh
$ git clone git@github.com:KevyJQ/intelligent-realestate.git 
```

Este comando create un directory llamado `intelligent-realestate`.

> Nota: informacion de como configurar la llave ssh esta https://docs.github.com/en/authentication/connecting-to-github-with-ssh/generating-a-new-ssh-key-and-adding-it-to-the-ssh-agent 
## Como ver informacion del projecto

```shell
$ git branch
* main
$ git branch -va
* main                e5fca6a Descripcion del sistema
  remotes/origin/HEAD -> origin/main
  remotes/origin/main e5fca6a Descripcion del sistema`
```

> Nota: Para mover todos los archivos de una carpeta a la direcion pasada se usa el comando:
	$ mv * ../

## Para compilarlo y ejecutarlo

```shell
# Compilar y correr test
$ mvn package

# Compilar, correr test y generar jar con dependencias
$ mvn assembly:assembly -DdescriptorId=jar-with-dependencies


# Ver archivos en el jar
$ jar tf ./target/intelligent_RealEstate-0.0.1-SNAPSHOT-jar-with-dependencies.jar

$ cd intelligent-realestate	//ingresamos al directorio
$ java -cp target/intelligent_RealEstate-0.0.1-SNAPSHOT-jar-with-dependencies.jar \
       com.intelligent.realestate.main.Main
```
> Nota: com.intelligent.realestate.main  -> es el package donde se encuentra
>	IntelligentRealEstateMain	-> es el nombre de tu archivo Main
 

> Note: Las dependencias de maven estan en:
>
> Windows: C:\Users\<User_Name>\.m2

## Como conectarse a la base de datos

```shell
# Ver la version the Maria DB
$ mysql --version

# Conectarse a la base de datos
$ mysql -u root -p
```

## Stop and Start MariaDb

```shell
# Start server y mandarlo a segundo plano.
$ mysqld &

# Stop server
$ mysqladmin -u root -p shutdown
```
## Build and start spring-boot

```shell
# Build the project
$ mvn compile

# Start spring boot
$ mvn spring-boot:run

# Probar microservices
$ curl -X GET localhost:8080 -H 'Content-type:application/json'
Real Estate Intelligence

$ curl -X GET localhost:8080/arrendador/12 -H 'Content-type:application/json'
{"nombre1":"Test","nombre2":"Test nombre2 Sun Sep 11 15:32:29 PDT 2022","apellidoMaterno":"Test materno","apellidoPaterno":"Test Apellido 1662935549051","edad":23,"correo":"test@gmail.com","celular":"659 864 9454","direccion":null,"realEstate":null,"idArrendador":12,"realEstates":[]}
```
