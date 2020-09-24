# Spring_mvc_nullToEmpty

## 概要

mvc.xmlに下記の設定をしたときにjsonのnullの値に影響があるか確認する。
```
<property name="nullToEmpty" value="true" />
```

## Webページ生成

### jetty起動

```
mvn clean
mvn compile
mvn jetty:run
```

### URL

http://localhost:8080

```
curl localhost:8080
```

```
<!DOCTYPE html>
<html>
<head>
        <meta charset="utf-8">
        <title>Research null to empty.</title>
</head>
<body>
        Hello World!
</body>
</html>
```

## RestAPI

### curl実行

ライブラリのバージョンを変えて、挙動の違いを見る。

設定値は下記。いずれもString。
- value = null
- onclick = onclick

#### バージョンアップ前

- Spring Framework : 4.1.6.RELEASE
- Jackson 
  - core : 2.5.1
  - annotations : 2.5.1
  - databind : 2.5.1

curl実行
```
curl http://localhost:8080/test
```
```
{"value":"","onclick":"onclick"}
```
valueのnull → 空文字変換が効いている。

ヘッダ取得
```
curl http://localhost:8080/test --head
```
```
HTTP/1.1 200 OK
Date: Thu, 24 Sep 2020 09:37:22 GMT
Content-Type: application/json;charset=utf-8
Content-Length: 32
Server: Jetty(9.4.19.v20190610)
```

#### バージョンアップ後

- Spring Framework : 5.2.2.RELEASE
- Jackson 
  - core : 2.9.10
  - annotations : 2.9.9
  - databind : 2.9.9.3

curl実行
```
curl http://localhost:8080/test
```
```
{"value":null,"onclick":"onclick"}
```
valueのnull → 空文字変換が効いていない。

ヘッダ取得
```
curl http://localhost:8080/test --head
```
```
HTTP/1.1 200 OK
Date: Thu, 24 Sep 2020 09:34:20 GMT
Content-Type: application/json
Content-Length: 34
Server: Jetty(9.4.19.v20190610)
```

## 参考

[山崎屋の技術メモ : Spring MVC を使用して Web アプリケーションの作成。Boot は使わない。](https://www.shookuro.com/entry/2020/03/22/122906)

[Qiita : MavenでJettyを動かす](https://qiita.com/moris/items/4538773013d4e17ddecc)  
jettyプラグインの使用方法と正しいパスについて

[Spring : Spring で REST サービスを構築](https://spring.pleiades.io/guides/tutorials/bookmarks/)  
RestAPIの作成方法
