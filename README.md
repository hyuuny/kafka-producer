# 카프카 커맨드 라인 툴 설치

---

## version 2.12-2.5.0

<a href="https://kafka.apache.org/downloads" target="_blank">카프카 바이너리 파일 다운로드</a>

<br>

### server.properties 설정
```shell
vi config/server.properties

# 주석 해제 후 기재
listeners=PLAINTEXT://localhost:9092
advertised.listeners=PLAINTEXT://localhost:9092
```

<br>

### 주키퍼 실행

```shell
bin/zookeeper-server-start.sh config/zookeeper.properties
```

<br>

### 브로커 실행

```shell
bin/kafka-server-start.sh config/server.properties
```

<br>

### 테스트 편의를 위한 hosts 설정

```shell
sudo vi /etc/hosts

Password:
127.0.0.1    localhost
255.255.255.255    broadcasthost
::1             localhost

127.0.0.1 my-kafka
```

<br>

### 카프카 토픽 확인

```shell
bin/kafka-console-consumer.sh --bootstrap-server my-kafka:9092 --topic test --from-beginning
```

<br>

### 카프카 토픽 Key-Value 확인

```shell
bin/kafka-console-consumer.sh --bootstrap-server my-kafka:9092 --topic test --property print.key=true --property key.separator="-" --from-beginning
```



