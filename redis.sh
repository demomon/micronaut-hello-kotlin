echo "> Removing Leika Redis container"
docker rm -f leika-redis
echo "> Creating new Leika Redis container"
docker run --name leika-redis -p 6379:6379 -d redis:5-alpine
