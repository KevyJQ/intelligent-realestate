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
