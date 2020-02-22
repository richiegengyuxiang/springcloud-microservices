FROM mysql:5.7.29
ENV MYSQL_DATABASE=microservices_app \
    MYSQL_ROOT_PASSWORD=123456
ADD dump.sql /docker-entrypoint-initdb.d
EXPOSE 3306
EXPOSE 80 2222
