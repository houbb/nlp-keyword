# nlp-keyword

[nlp-keyword](https://github.com/houbb/nlp-keyword) 高性能的 java 分词关键词提取实现，基于分词 [segment](https://github.com/houbb/segment)。

愿景：成为 java 最好用的关键词工具。

[![Build Status](https://travis-ci.com/houbb/nlp-keyword.svg?branch=master)](https://travis-ci.com/houbb/nlp-keyword)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.houbb/keyword/badge.svg)](http://mvnrepository.com/artifact/com.github.houbb/nlp-keyword)
[![](https://img.shields.io/badge/license-Apache2-FF0080.svg)](https://github.com/houbb/keyword/blob/master/LICENSE.txt)
[![Open Source Love](https://badges.frapsoft.com/os/v2/open-source.svg?v=103)](https://github.com/houbb/nlp-keyword)

## 特性

- 灵活的条件指定

- 基于 TF-IDF 算法的关键字算法

- 支持 auto-summary 自动摘要生成

> [变更日志](https://github.com/houbb/nlp-keyword/blob/master/CHANGELOG.md)

# 关键词快速开始

## maven 引入

```xml
<dependency>
    <groupId>com.github.houbb</groupId>
    <artifactId>keyword-core</artifactId>
    <version>1.1.0</version>
</dependency>
```

## 快速开始

- 获取关键词

```java
final String text = "这是一个伸手不见五指的黑夜，夜太美。";

List<IKeywordResult> keywords =  KeywordHelper.keyword(text);
Assert.assertEquals("[伸手不见|0.86879235325, 太美|0.70848301840625, 伸手不见五指|0.63371734601875, 黑夜|0.509854654010625, 伸手|0.43563643037625]", keywords.toString());
```

- 指定返回的个数

```java
final String text = "这是一个伸手不见五指的黑夜，夜太美。";

List<IKeywordResult> keywords =  KeywordHelper.keyword(text, 1);
Assert.assertEquals("[伸手不见|0.86879235325]", keywords.toString());
```

- 指定返回的格式

```java
final String text = "这是一个伸手不见五指的黑夜，夜太美。";

List<String> keywords =  KeywordHelper.keyword(text, 1, KeywordResultHandlers.words());
Assert.assertEquals("[伸手不见]", keywords.toString());
```


# 自动摘要

## maven 引入

```xml
<dependency>
    <groupId>com.github.houbb</groupId>
    <artifactId>keyword-summary</artifactId>
    <version>1.1.0</version>
</dependency>
```

## 入门例子

```java
final String text = "你好啊，我的老伙计。最近过得怎么样？我实在是觉得太久没有看见你了。听说北海的花开了，太久没去了。故事的最后会怎么样呢？我也不清楚。";

String summary = AutoSummaryHelper.autoSummary(text);
```

# ROAD-MAP

- [] 字典数据独立，便于用户自定义选择

- [] 文本相似度

- [x] auto-summary 自动摘要

- [ ] 完善文档+测试用例