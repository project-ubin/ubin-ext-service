# Project Ubin Phase 2 - External Service (Mock MEPS+ Service)
This is a Ubin common implementation of a mock RTGS system, MEPS+ service to simulate Pledge and Redeem approvals from the Central Bank. This mock service is common for the three prototypes (Corda, Hyperledger Fabric and Quorum). 

The [common UI](https://github.com/project-ubin/ubin-ui) is configured to request Pledge through this mock service, where it is a pass-through "approval" and invocation to the DLT to the DLT Pledge function. The UI sends Redeem requests to the mock service for all prototypes except Corda. In Corda, the UI will send the Redeem request to the DLT.

This project is developed using Spring Boot framework and IntelliJ IDE with Kotlin as the programming language.

## Pre-Requisites
1. Git
2. JDK 8
3. IntelliJ

## Build

1\. Clone the repository
    
```sh
$ git clone https://github.com/project-ubin/ubin-ext-service.git
```
2\. Go to newly created folder
    
```sh
$ cd ubin-ext-service
```

3\. Build project using gradle

```sh
$ ./gradlew build
```
4\. Build artifact can be found at

    build/libs/ubin-ext-service-0.0.1-SNAPSHOT.jar


### Start External Service
1\. Update `application.properties file 
```sh
ubin-ext-service/application.properties
```

#### Corda Configurations

```sh    
PledgeURI=http://cordaknqx-node1.southeastasia.cloudapp.azure.com:10004/api/fund/pledge
RedeemURI=http://cordaknqx-node1.southeastasia.cloudapp.azure.com:10004/api/fund/redeem 
Dlt=Corda
```

Note: RedeemURI is not used for Corda but it is required to be in properties as a placeholder.

#### Hyperledger Fabrics Configurations

```sh    
PledgeURI=http://fabricnx02.southeastasia.cloudapp.azure.com:8080/api/fund/pledge
RedeemURI=http://fabricnx02.southeastasia.cloudapp.azure.com:8080/api/fund/redeem
Dlt=Fabric
```

#### Quorum Configurations

```sh    
PledgeURI=http://quorumnx02.southeastasia.cloudapp.azure.com:3000/api/fund/pledge
RedeemURI=http://quorumnx02.southeastasia.cloudapp.azure.com:3000/api/fund/redeem
Dlt=Quorum  
```

Note: The host configured at the endpoint in properties file is Central Bank VM host. In the case Central Bank VM domain changes, configuration update is necessary.

2\. Copy built JAR artifact and properties files to the Central Bank VM
```sh  
ubin-ext-service/build/libs/ubin-ext-service-0.0.1-SNAPSHOT.jar
ubin-ext-service/application.properties
```
Note: ensure both files are in the same directory

3\. From Central Bank VM Start application

```sh
java -jar -Dspring.config.location=application.properties -Dserver.port=9001 ubin-ext-service-0.0.1-SNAPSHOT.jar
```

# API

## Pledge API

API used by bank client application to submit pledge request to add money to the bank DLT account through Central Bank.

### <code>POST</code> `meps/pledge`

Example URL : 

    http://centralBankHost:9001/meps/pledge


### Request - Body
 - **receiver** - Swift/BIC code of the bank
 - **transactionAmount** - Amount to be pledged to DLT account
 - **channel** - only used for Hyperledger Fabric

#### Sample:
```sh
{
  "receiver": "MASGSGSG",
  "transactionAmount": 10000000
}
```



## Redeem API

API used by bank client application to submit redeem request to witdraw money from the bank DLT account through Central Bank.

### <code>POST</code> `meps/redeem`

    http://centralBankHost:9001/meps/redeem

### Request - Body
 - **sender** - Swift/BIC code of the bank
 - **transactionAmount** - Amount to be redeemed from DLT account
 - **channel** - only used for Hyperledger Fabric

#### Sample:
```sh
{
  "sender": "MASGSGSG",
  "transactionAmount": 10000000
}
```

# License 
 
Copyright 2017 The Association of Banks in Singapore
 
   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at
 
     http://www.apache.org/licenses/LICENSE-2.0
 
   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.