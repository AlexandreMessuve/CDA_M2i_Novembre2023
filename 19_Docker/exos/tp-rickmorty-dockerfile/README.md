# 04-tp-global-vuejs

## run dockerfile

```bash
docker build -t tp-global-vuejs
docker run -p 3000:80 -d --name rickmorty tp-global-vuejs

```

```bash
docker tag tp-global-vuejs alexandremessuvem2i/tp-global-vuejs
docker tag tp-global-vuejs alexandremessuvem2i/tp-global-vuejs:1.0
docker push alexandremessuvem2i/tp-global-vuejs
docker push alexandremessuvem2i/tp-global-vuejs:1.0
```

[Image tp-global-vuejs](https://hub.docker.com/r/alexandremessuvem2i/tp-global-vuejs)