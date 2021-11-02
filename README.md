# Project1

#### **Description**

The project is to develop job matching making system, user can register as job seeker and company user. The jobseeker need to provide their basic personal information,educational background  and expected job information. For company user, they need to provide the company information before they post a job requirement post.  Then the system will match the job seeker's CV and job requirement base on the educational background and expect job information to generates the recommendation of post to job seeker and CV to the company users

### **v1.6.0** 

------

#### Framework Enhancements:

- update matching algorithm
- Email  register verification 

##### Bug Fixes：

- Not matching CV for company user 

------



#### <u>**Require Java version : Java 8**</u>

**Deploy URL:** https://ec2-18-205-41-24.compute-1.amazonaws.com/

**GitHub URL:**https://github.com/s3633197/PP-1-S2-2021-WED0430PM-Group3

### <u>Technical Stack</u>

##### backend

- Spring boot 
- Spring Security 
- My SQL
- Mybatis
- Redis 
- Maven

**frontend**

- VUE
- element-ui
- axios

## How to run the project

## backend Project setup

**Prerequisites**

- Java version:  **Oracle Java 8**
- **Redis** installed  in the machine 

1. **Import the project using `Intellij IDE` or other IDE that support Java and Maven**

2. If maven is not running, use the command  in the terminal  to install dependencies 

   ```java
   maven install
   ```

3. After configuration and installing, the project is ready to start 

## frontend Project setup

```
yarn install
```

### Compiles and hot-reloads for development

```
yarn serve
```

### Compiles and minifies for production

```
yarn build
```

### Customize configuration

See [Configuration Reference](https://cli.vuejs.org/config/).