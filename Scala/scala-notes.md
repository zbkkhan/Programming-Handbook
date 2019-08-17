# Scala Handbook

---

## Motivation

Scala is a highly scalable language as the name suggests and its combination of merging functional and object-oriented paradigms make it a very interesting language to learn. Writing Scala often results in consice meaningful code due to a lack of ceremonial code within the language aswell.

## Strings

Useful functions:

```scala
string.equalsIgnoreCase()
string.split(",").map(_.trim)

```

String equality:

> String equality performs a null check before evaluation

```scala
val s1 = "Hello"
val s2 = "H" + "ello"
val s3 = null
s1 == s2 //True
s1 == s3 //False
```


