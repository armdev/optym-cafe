# optym-cafe

Build the project:

mvn clean package -U -Dmaven.test.skip=true

run the project
docker-compose up -d --build

example request

http://localhost:2025/api/v2/order/coffee?coffeeType=Americano

benchmark: siege --concurrent=10000 --time=5M http://localhost:2025/api/v2/order/coffee?coffeeType=Americano

benchmark: siege -b -c 10000 -r 10 http://localhost:2025/api/v2/order/coffee?coffeeType=Americano

order

http://localhost:2025/swagger-ui.html

coffee

http://localhost:2026/swagger-ui.html
