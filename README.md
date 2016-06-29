# SparkCouchDBDemoApp
Demo App: Spark (Java) + CouchDB

It is just a simple demo app using Spark + LightCouchDB + Java Integration.


##EndPoints

* Get All Messages

```java
curl -X GET -H "http://localhost:9090/messages"
```

```java
{
    "Status": "success",
    "Data": [
        {
            "From": "Hiren",
            "To": "Kirtan",
            "Message": "I am Good!!! How are you.",
            "Created": "Jun 29, 2016 12:52:41 PM",
            "_id": "24ddc62832e443eca84da34ed5fa3b50",
            "_rev": "1-af273edee89fa4177aa2e17b215bbee4"
        },
        {
            "From": "Ketan",
            "To": "Soni",
            "Message": "Hello Guyz!!!",
            "Created": "Jun 29, 2016 2:22:54 PM",
            "_id": "f8f42f7e06074666857bc8e3eb240b19",
            "_rev": "2-e2ac2691ad7db79f2b5c36c23f331829"
        }
    ]
}
```

* Delete Message By Id

```java
curl -X DELETE -H "Content-Type: application/json" -d '{
    "_rev" : "5-a7647eb614206367838bae923dfdcbff"
}' "http://localhost:9090/messages/01a3621f32e54050b2addab7271f497a"

```

```java
{
    "Status": "success",
    "Data": {
        "id": "01a3621f32e54050b2addab7271f497a",
        "rev": "6-6ee10468fd93ed184e1020696c676348"
    }
}
```

* Add New Message

```java
curl -X POST -H "Content-Type: application/json" -d '{
    "From" : "Ketan",
    "To" : "Soni",
    "Message" : "Hello Guyz!!!"
}' "http://localhost:9090/messages"

```

```java
{
    "Status": "success",
    "Data": {
        "id": "f8f42f7e06074666857bc8e3eb240b19",
        "rev": "1-4687522e9f00b227bfaff34045fdddf7"
    }
}

```


* Update Message By Id

```java
curl -X PUT -H "Content-Type: application/json" -d '{
    "From" : "Ketan",
    "To" : "Soni",
    "Message" : "Hello Guyz!!!"
}' "http://localhost:9090/messages/f8f42f7e06074666857bc8e3eb240b19"

```

```java
{
    "Status": "success",
    "Data": {
        "id": "f8f42f7e06074666857bc8e3eb240b19",
        "rev": "1-4687522e9f00b227bfaff34045fdddf7"
    }
}

```
