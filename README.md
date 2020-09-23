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

## 参考

[山崎屋の技術メモ : Spring MVC を使用して Web アプリケーションの作成。Boot は使わない。](https://www.shookuro.com/entry/2020/03/22/122906)

[Qiita : MavenでJettyを動かす](https://qiita.com/moris/items/4538773013d4e17ddecc)  
jettyプラグインの使用方法と正しいパスについて