# Docker

[docker docs](https://docs.docker.com/)

## Get Docker

Get Docker Engine - Community for [Ubuntu](https://docs.docker.com/install/linux/docker-ce/ubuntu/)
Get Docker Engine - Community for [Windows](https://docs.docker.com/docker-for-windows/)

```bash
sudo apt-get remove docker docker-engine docker.io containerd runc
sudo apt-get update
sudo apt-get install \
    apt-transport-https \
    ca-certificates \
    curl \
    gnupg-agent \
    software-properties-common
curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -
```


```Set up stable repository
sudo add-apt-repository \
   "deb [arch=amd64] https://download.docker.com/linux/ubuntu \
   $(lsb_release -cs) \
   stable"
```

OR

```MINT USERS : Edit repositories list
vi /etc/apt/sources.list.d/official-package-repositories.list
```
```Add this
deb [arch=amd64] https://download.docker.com/linux/ubuntu bionic stable
```

Then

```
sudo apt-get update
sudo apt-get install docker-ce docker-ce-cli containerd.io
sudo docker run hello-world
```

## PgAdmin4

pgAdmin 4 is a web based administration tool for the PostgreSQL database. 

https://hub.docker.com/r/dpage/pgadmin4

```
docker pull dpage/pgadmin4
sudo docker run -p 5050:5050 -e "PGADMIN_DEFAULT_EMAIL=xxxx@xxxx.com" -e "PGADMIN_DEFAULT_PASSWORD=xxxx" dpage/pgadmin4
```



