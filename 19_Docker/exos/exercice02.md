**Exercice : Gestion d'images Docker**

En ligne de commande on souhaite :

1. **Téléchargement d'une image :**
   - Recherchez et téléchargez l'image Docker officielle pour le serveur web Nginx.

2. **Liste d'images :**
   - Affichez la liste des images Docker présentes sur votre machine.

3. **Suppression d'une image :**
   - Supprimez l'image Nginx que vous venez de télécharger de votre machine.

4. **Téléchargement de plusieurs images :**
   - Téléchargez les images Docker officielles pour MySQL et Redis sur votre machine.

5. **Liste d'images après téléchargement :**
   - Affichez à nouveau la liste des images Docker sur votre machine pour vérifier que les images de MySQL et Redis ont été téléchargées avec succès.

6. **Affichage détaillé d'une image :**
   - Affichez les détails (metadata) de l'image Mysql que vous avez téléchargée précédemment.

7. **Historique d'une image :**
   - Affichez l'historique de l'image MySQL pour voir les différentes couches qui la composent.

8. **Recherche d'images :**
   - Rechercher une image Docker liée à un service ou une technologie de votre choix. Choisissez une image intéressante et affichez quelques informations à son sujet.

Cet exercice devrait vous permettre de vous familiariser avec la manipulation d'images Docker à un niveau basique. N'hésitez pas à consulter la documentation Docker au besoin.



```bash
#1
docker search nginx
docker pull nginx

#2
docker images

#3
docker rmi nginx

#4
docker pull mysql;docker pull redis

#5
docker images

#6
docker inspect mysql

#7
docker history mysql

#8
docker search node
docker pull node
docker images
docker inspect node
```

```json
[
    {
        "Id": "sha256:743c6c23d6f7bb76172a9821d9db119c97d0be42141daac599379014a6912006",
        "RepoTags": [
            "node:latest"
        ],
        "RepoDigests": [
            "node@sha256:d885885ad8e100d27b65e7837075afea042cc8515ec066cd82cdf34e26fc9fb8"
        ],
        "Parent": "",
        "Comment": "buildkit.dockerfile.v0",
        "Created": "2024-07-19T15:48:06Z",
        "DockerVersion": "",
        "Author": "",
        "Config": {
            "Hostname": "",
            "Domainname": "",
            "User": "",
            "AttachStdin": false,
            "AttachStdout": false,
            "AttachStderr": false,
            "Tty": false,
            "OpenStdin": false,
            "StdinOnce": false,
            "Env": [
                "PATH=/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin",
                "NODE_VERSION=22.5.1",
                "YARN_VERSION=1.22.22"
            ],
            "Cmd": [
                "node"
            ],
            "ArgsEscaped": true,
            "Image": "",
            "Volumes": null,
            "WorkingDir": "",
            "Entrypoint": [
                "docker-entrypoint.sh"
            ],
            "OnBuild": null,
            "Labels": null
        },
        "Architecture": "amd64",
        "Os": "linux",
        "Size": 1111037459,
        "GraphDriver": {
            "Data": {
                "LowerDir": "/var/lib/docker/overlay2/7b32e07c5e9369e4f771177464a727b8a1aa66ff08e6eec479dc234fb0cc4288/diff:/var/lib/docker/overlay2/1c1154e19cb6cffa1faaeeb9886e86dd55e45400c65ea2d42be1b0d9b9b93af1/diff:/var/lib/docker/overlay2/824bd4b597d7dd1d58b087e70768b14ca6f9cb850581952b12836f8a78b9d703/diff:/var/lib/docker/overlay2/3cb497d522cfb9301c8220b1ee6e3ba88f2a83440481c637c054f0ce1b3f42fb/diff:/var/lib/docker/overlay2/21d344e897f570a81586514016b25bc511f28eff696c31d092485f6ef23218b9/diff:/var/lib/docker/overlay2/dac0a1a49014b537d21af2ce8cda9f3ae5f473c4bf9b5837e5413bf958d64208/diff:/var/lib/docker/overlay2/ac57c72eca16a79e297883f09821c0b7b48bf9244dcc4a0dd6acdbb71a6925fa/diff",
                "MergedDir": "/var/lib/docker/overlay2/ff0b4a00d76e507c56519092e88cf701c820efa7a617347695b3a2ff4533e973/merged",
                "UpperDir": "/var/lib/docker/overlay2/ff0b4a00d76e507c56519092e88cf701c820efa7a617347695b3a2ff4533e973/diff",
                "WorkDir": "/var/lib/docker/overlay2/ff0b4a00d76e507c56519092e88cf701c820efa7a617347695b3a2ff4533e973/work"
            },
            "Name": "overlay2"
        },
        "RootFS": {
            "Type": "layers",
            "Layers": [
                "sha256:15bb10f9bb3af155537c0f594b736881ca625d0e9bcd6f948588f78aec30a710",
                "sha256:8ada682d37800f71d01a827d77502ce654d9e064837547f3e80fae814d24b187",
                "sha256:b779a72428fa92f24ed5a591dce6ff965ae2baf39e48a22bf88d46d62a80e4ab",
                "sha256:b11bb163e2634aaf7a61de5842b1092b9b85f4f543a93061cde332b747beedf5",
                "sha256:fade3b0815f25e0fd8a5a0f04bd1b09ae114f8de72a5d20723dd89a606a49bf1",
                "sha256:afdc25fcf5b785d9944cd1c5deda32cd83d39210a8ed72d7cace137efb104f9a",
                "sha256:a2b73783c9939f3d282fffa2212dd12c97006da51562e4f45aecb9363e71104f",
                "sha256:eb8960559c06aeeb993e47c7dbbe1154e79e28e86806143fab83d8b519ce8295"
            ]
        },
        "Metadata": {
            "LastTagTime": "0001-01-01T00:00:00Z"
        }
    }
]

```