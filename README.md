#软件设计与体系结构实验:
##武大食堂饭菜评价系统
![GitHub top language](https://img.shields.io/github/languages/top/A-Salty-Fish/SoftwareArchitectureProject)
![GitHub](https://img.shields.io/github/license/A-Salty-Fish/SoftwareArchitectureProject)
![GitHub repo size](https://img.shields.io/github/repo-size/A-Salty-Fish/SoftwareArchitectureProject)
![GitHub contributors](https://img.shields.io/github/contributors/A-Salty-Fish/SoftwareArchitectureProject)
![GitHub last commit](https://img.shields.io/github/last-commit/A-Salty-Fish/SoftwareArchitectureProject)

##开发环境
### 后端(具体版本参考pom.xml)
* Java
* SpringBoot
* Mybatis
* Swagger-UI
* Mysql 8.0
### 前端
* Vue 2.x
* [vue-element-admin](https://panjiachen.gitee.io/vue-element-admin-site/zh/guide/)

##基本需求：

* 基本的注册登录模块。（管理员与用户）
* 用户添加菜品。
* 用户评价菜品。（星级，色香味选项，评论）
* 用户查看菜品评价。（排行榜，按食堂搜索，菜品搜索等功能）
* 用户查看本人评论历史。
* 管理员管理菜品。（删去不合格的用户添加的菜品）

##附加需求：
* 食堂地理分布图。
* 管理员在地图上添加食堂。
* 食堂导航图。
* 食堂食品分布图。

##最终需求
* 砍去用户模块，只剩管理员CRUD模块。
* 附加需求没有时间做

##前端预览图
* 用户管理模块
![image](https://github.com/A-Salty-Fish/SoftwareArchitectureProject/blob/master/Image/user.png?raw=true)
* 食堂管理模块
![image](https://github.com/A-Salty-Fish/SoftwareArchitectureProject/blob/master/Image/canteen.png?raw=true)
* 菜品管理模块
![image](https://github.com/A-Salty-Fish/SoftwareArchitectureProject/blob/master/Image/food.png?raw=true)
* 评论管理模块
![image](https://github.com/A-Salty-Fish/SoftwareArchitectureProject/blob/master/Image/comment.png?raw=true)

##后端API
注:由于前端开发偷懒导致很多没用上

{
    
"swagger": "2.0",

    "info": {
        "description": "软件架构作业",
        "version": "v1.0",
        "title": "A-Salty-Fish 的 Swagger API文档",
        "termsOfService": "https://github.com/A-Salty-Fish/",
        "contact": {
            "name": "A-Salty-Fish",
            "url": "https://github.com/A-Salty-Fish/",
            "email": "A_Salty_Fish@126.com"
        },
        "license": {
            "name": "MIT",
            "url": "https://mit-license.org/"
        }
    },
    "host": "localhost:8080",
    "basePath": "/",
    "tags": [
        {
            "name": "canteen-controller",
            "description": "Canteen Controller"
        },
        {
            "name": "comment-controller",
            "description": "Comment Controller"
        },
        {
            "name": "food-controller",
            "description": "Food Controller"
        },
        {
            "name": "user-controller",
            "description": "User Controller"
        }
    ],
    "paths": {
        "/canteen/AddCanteen": {
            "post": {
                "tags": [
                    "canteen-controller"
                ],
                "summary": "AddCanteen",
                "operationId": "AddCanteenUsingPOST",
                "consumes": [
                    "application/json"
                ],
                "produces": [
                    "*/*"
                ],
                "responses": {
                    "200": {
                        "description": "OK",
                        "schema": {
                            "$ref": "#/definitions/Canteen"
                        }
                    },
                    "201": {
                        "description": "Created"
                    },
                    "401": {
                        "description": "Unauthorized"
                    },
                    "403": {
                        "description": "Forbidden"
                    },
                    "404": {
                        "description": "Not Found"
                    }
                },
                "deprecated": false
            }
        },
        "/canteen/DeleteCanteenById/{id}": {
            "delete": {
                "tags": [
                    "canteen-controller"
                ],
                "summary": "DeleteCanteenById",
                "operationId": "DeleteCanteenByIdUsingDELETE",
                "produces": [
                    "*/*"
                ],
                "parameters": [
                    {
                        "name": "id",
                        "in": "path",
                        "description": "id",
                        "required": true,
                        "type": "integer",
                        "format": "int32"
                    }
                ],
                "responses": {
                    "200": {
                        "description": "OK",
                        "schema": {
                            "$ref": "#/definitions/Canteen"
                        }
                    },
                    "204": {
                        "description": "No Content"
                    },
                    "401": {
                        "description": "Unauthorized"
                    },
                    "403": {
                        "description": "Forbidden"
                    }
                },
                "deprecated": false
            }
        },
        "/canteen/GetAllCanteen": {
            "get": {
                "tags": [
                    "canteen-controller"
                ],
                "summary": "GetAllCanteen",
                "operationId": "GetAllCanteenUsingGET",
                "produces": [
                    "*/*"
                ],
                "responses": {
                    "200": {
                        "description": "OK",
                        "schema": {
                            "type": "array",
                            "items": {
                                "$ref": "#/definitions/Canteen"
                            }
                        }
                    },
                    "401": {
                        "description": "Unauthorized"
                    },
                    "403": {
                        "description": "Forbidden"
                    },
                    "404": {
                        "description": "Not Found"
                    }
                },
                "deprecated": false
            }
        },
        "/canteen/GetCanteenById/{id}": {
            "get": {
                "tags": [
                    "canteen-controller"
                ],
                "summary": "GetCanteenById",
                "operationId": "GetCanteenByIdUsingGET",
                "produces": [
                    "*/*"
                ],
                "parameters": [
                    {
                        "name": "id",
                        "in": "path",
                        "description": "id",
                        "required": true,
                        "type": "integer",
                        "format": "int32"
                    }
                ],
                "responses": {
                    "200": {
                        "description": "OK",
                        "schema": {
                            "$ref": "#/definitions/Canteen"
                        }
                    },
                    "401": {
                        "description": "Unauthorized"
                    },
                    "403": {
                        "description": "Forbidden"
                    },
                    "404": {
                        "description": "Not Found"
                    }
                },
                "deprecated": false
            }
        },
        "/canteen/GetCanteenByName/{name}": {
            "get": {
                "tags": [
                    "canteen-controller"
                ],
                "summary": "GetCanteenByName",
                "operationId": "GetCanteenByNameUsingGET",
                "produces": [
                    "*/*"
                ],
                "parameters": [
                    {
                        "name": "name",
                        "in": "path",
                        "description": "name",
                        "required": true,
                        "type": "string"
                    }
                ],
                "responses": {
                    "200": {
                        "description": "OK",
                        "schema": {
                            "type": "array",
                            "items": {
                                "$ref": "#/definitions/Canteen"
                            }
                        }
                    },
                    "401": {
                        "description": "Unauthorized"
                    },
                    "403": {
                        "description": "Forbidden"
                    },
                    "404": {
                        "description": "Not Found"
                    }
                },
                "deprecated": false
            }
        },
        "/canteen/GetCanteenPage/{CurrentPage}/{PageSize}": {
            "get": {
                "tags": [
                    "canteen-controller"
                ],
                "summary": "GetCanteenPage",
                "operationId": "GetCanteenPageUsingGET",
                "produces": [
                    "*/*"
                ],
                "parameters": [
                    {
                        "name": "CurrentPage",
                        "in": "path",
                        "description": "CurrentPage",
                        "required": true,
                        "type": "integer",
                        "format": "int32"
                    },
                    {
                        "name": "PageSize",
                        "in": "path",
                        "description": "PageSize",
                        "required": true,
                        "type": "integer",
                        "format": "int32"
                    }
                ],
                "responses": {
                    "200": {
                        "description": "OK",
                        "schema": {
                            "type": "array",
                            "items": {
                                "$ref": "#/definitions/Canteen"
                            }
                        }
                    },
                    "401": {
                        "description": "Unauthorized"
                    },
                    "403": {
                        "description": "Forbidden"
                    },
                    "404": {
                        "description": "Not Found"
                    }
                },
                "deprecated": false
            }
        },
        "/canteen/UpdateCanteen": {
            "post": {
                "tags": [
                    "canteen-controller"
                ],
                "summary": "UpdateCanteen",
                "operationId": "UpdateCanteenUsingPOST",
                "consumes": [
                    "application/json"
                ],
                "produces": [
                    "*/*"
                ],
                "responses": {
                    "200": {
                        "description": "OK",
                        "schema": {
                            "$ref": "#/definitions/Canteen"
                        }
                    },
                    "201": {
                        "description": "Created"
                    },
                    "401": {
                        "description": "Unauthorized"
                    },
                    "403": {
                        "description": "Forbidden"
                    },
                    "404": {
                        "description": "Not Found"
                    }
                },
                "deprecated": false
            }
        },
        "/comment/AddComment": {
            "post": {
                "tags": [
                    "comment-controller"
                ],
                "summary": "AddComment",
                "operationId": "AddCommentUsingPOST",
                "consumes": [
                    "application/json"
                ],
                "produces": [
                    "*/*"
                ],
                "responses": {
                    "200": {
                        "description": "OK",
                        "schema": {
                            "$ref": "#/definitions/Comment"
                        }
                    },
                    "201": {
                        "description": "Created"
                    },
                    "401": {
                        "description": "Unauthorized"
                    },
                    "403": {
                        "description": "Forbidden"
                    },
                    "404": {
                        "description": "Not Found"
                    }
                },
                "deprecated": false
            }
        },
        "/comment/DeleteCommentById/{id}": {
            "delete": {
                "tags": [
                    "comment-controller"
                ],
                "summary": "DeleteCommentById",
                "operationId": "DeleteCommentByIdUsingDELETE",
                "produces": [
                    "*/*"
                ],
                "parameters": [
                    {
                        "name": "id",
                        "in": "path",
                        "description": "id",
                        "required": true,
                        "type": "integer",
                        "format": "int32"
                    }
                ],
                "responses": {
                    "200": {
                        "description": "OK",
                        "schema": {
                            "$ref": "#/definitions/Comment"
                        }
                    },
                    "204": {
                        "description": "No Content"
                    },
                    "401": {
                        "description": "Unauthorized"
                    },
                    "403": {
                        "description": "Forbidden"
                    }
                },
                "deprecated": false
            }
        },
        "/comment/GetAllComment": {
            "get": {
                "tags": [
                    "comment-controller"
                ],
                "summary": "GetAllComment",
                "operationId": "GetAllCommentUsingGET",
                "produces": [
                    "*/*"
                ],
                "responses": {
                    "200": {
                        "description": "OK",
                        "schema": {
                            "type": "array",
                            "items": {
                                "$ref": "#/definitions/Comment"
                            }
                        }
                    },
                    "401": {
                        "description": "Unauthorized"
                    },
                    "403": {
                        "description": "Forbidden"
                    },
                    "404": {
                        "description": "Not Found"
                    }
                },
                "deprecated": false
            }
        },
        "/comment/GetCommentByContent/{content}": {
            "get": {
                "tags": [
                    "comment-controller"
                ],
                "summary": "GetCommentByContent",
                "operationId": "GetCommentByContentUsingGET",
                "produces": [
                    "*/*"
                ],
                "parameters": [
                    {
                        "name": "content",
                        "in": "path",
                        "description": "content",
                        "required": true,
                        "type": "string"
                    }
                ],
                "responses": {
                    "200": {
                        "description": "OK",
                        "schema": {
                            "type": "array",
                            "items": {
                                "$ref": "#/definitions/Comment"
                            }
                        }
                    },
                    "401": {
                        "description": "Unauthorized"
                    },
                    "403": {
                        "description": "Forbidden"
                    },
                    "404": {
                        "description": "Not Found"
                    }
                },
                "deprecated": false
            }
        },
        "/comment/GetCommentById/{id}": {
            "get": {
                "tags": [
                    "comment-controller"
                ],
                "summary": "GetCommentById",
                "operationId": "GetCommentByIdUsingGET",
                "produces": [
                    "*/*"
                ],
                "parameters": [
                    {
                        "name": "id",
                        "in": "path",
                        "description": "id",
                        "required": true,
                        "type": "integer",
                        "format": "int32"
                    }
                ],
                "responses": {
                    "200": {
                        "description": "OK",
                        "schema": {
                            "$ref": "#/definitions/Comment"
                        }
                    },
                    "401": {
                        "description": "Unauthorized"
                    },
                    "403": {
                        "description": "Forbidden"
                    },
                    "404": {
                        "description": "Not Found"
                    }
                },
                "deprecated": false
            }
        },
        "/comment/GetCommentPage/{CurrentPage}/{PageSize}": {
            "get": {
                "tags": [
                    "comment-controller"
                ],
                "summary": "GetCommentPage",
                "operationId": "GetCommentPageUsingGET",
                "produces": [
                    "*/*"
                ],
                "parameters": [
                    {
                        "name": "CurrentPage",
                        "in": "path",
                        "description": "CurrentPage",
                        "required": true,
                        "type": "integer",
                        "format": "int32"
                    },
                    {
                        "name": "PageSize",
                        "in": "path",
                        "description": "PageSize",
                        "required": true,
                        "type": "integer",
                        "format": "int32"
                    }
                ],
                "responses": {
                    "200": {
                        "description": "OK",
                        "schema": {
                            "type": "array",
                            "items": {
                                "$ref": "#/definitions/Comment"
                            }
                        }
                    },
                    "401": {
                        "description": "Unauthorized"
                    },
                    "403": {
                        "description": "Forbidden"
                    },
                    "404": {
                        "description": "Not Found"
                    }
                },
                "deprecated": false
            }
        },
        "/comment/UpdateComment": {
            "post": {
                "tags": [
                    "comment-controller"
                ],
                "summary": "UpdateComment",
                "operationId": "UpdateCommentUsingPOST",
                "consumes": [
                    "application/json"
                ],
                "produces": [
                    "*/*"
                ],
                "responses": {
                    "200": {
                        "description": "OK",
                        "schema": {
                            "$ref": "#/definitions/Comment"
                        }
                    },
                    "201": {
                        "description": "Created"
                    },
                    "401": {
                        "description": "Unauthorized"
                    },
                    "403": {
                        "description": "Forbidden"
                    },
                    "404": {
                        "description": "Not Found"
                    }
                },
                "deprecated": false
            }
        },
        "/food/AddFood": {
            "post": {
                "tags": [
                    "food-controller"
                ],
                "summary": "AddFood",
                "operationId": "AddFoodUsingPOST",
                "consumes": [
                    "application/json"
                ],
                "produces": [
                    "*/*"
                ],
                "responses": {
                    "200": {
                        "description": "OK",
                        "schema": {
                            "$ref": "#/definitions/Food"
                        }
                    },
                    "201": {
                        "description": "Created"
                    },
                    "401": {
                        "description": "Unauthorized"
                    },
                    "403": {
                        "description": "Forbidden"
                    },
                    "404": {
                        "description": "Not Found"
                    }
                },
                "deprecated": false
            }
        },
        "/food/DeleteFoodById/{id}": {
            "delete": {
                "tags": [
                    "food-controller"
                ],
                "summary": "DeleteFoodById",
                "operationId": "DeleteFoodByIdUsingDELETE",
                "produces": [
                    "*/*"
                ],
                "parameters": [
                    {
                        "name": "id",
                        "in": "path",
                        "description": "id",
                        "required": true,
                        "type": "integer",
                        "format": "int32"
                    }
                ],
                "responses": {
                    "200": {
                        "description": "OK",
                        "schema": {
                            "$ref": "#/definitions/Food"
                        }
                    },
                    "204": {
                        "description": "No Content"
                    },
                    "401": {
                        "description": "Unauthorized"
                    },
                    "403": {
                        "description": "Forbidden"
                    }
                },
                "deprecated": false
            }
        },
        "/food/GetAllFood": {
            "get": {
                "tags": [
                    "food-controller"
                ],
                "summary": "GetAllFood",
                "operationId": "GetAllFoodUsingGET",
                "produces": [
                    "*/*"
                ],
                "responses": {
                    "200": {
                        "description": "OK",
                        "schema": {
                            "type": "array",
                            "items": {
                                "$ref": "#/definitions/Food"
                            }
                        }
                    },
                    "401": {
                        "description": "Unauthorized"
                    },
                    "403": {
                        "description": "Forbidden"
                    },
                    "404": {
                        "description": "Not Found"
                    }
                },
                "deprecated": false
            }
        },
        "/food/GetFoodById/{id}": {
            "get": {
                "tags": [
                    "food-controller"
                ],
                "summary": "GetFoodById",
                "operationId": "GetFoodByIdUsingGET",
                "produces": [
                    "*/*"
                ],
                "parameters": [
                    {
                        "name": "id",
                        "in": "path",
                        "description": "id",
                        "required": true,
                        "type": "integer",
                        "format": "int32"
                    }
                ],
                "responses": {
                    "200": {
                        "description": "OK",
                        "schema": {
                            "$ref": "#/definitions/Food"
                        }
                    },
                    "401": {
                        "description": "Unauthorized"
                    },
                    "403": {
                        "description": "Forbidden"
                    },
                    "404": {
                        "description": "Not Found"
                    }
                },
                "deprecated": false
            }
        },
        "/food/GetFoodByName/{name}": {
            "get": {
                "tags": [
                    "food-controller"
                ],
                "summary": "GetFoodByName",
                "operationId": "GetFoodByNameUsingGET",
                "produces": [
                    "*/*"
                ],
                "parameters": [
                    {
                        "name": "name",
                        "in": "path",
                        "description": "name",
                        "required": true,
                        "type": "string"
                    }
                ],
                "responses": {
                    "200": {
                        "description": "OK",
                        "schema": {
                            "type": "array",
                            "items": {
                                "$ref": "#/definitions/Food"
                            }
                        }
                    },
                    "401": {
                        "description": "Unauthorized"
                    },
                    "403": {
                        "description": "Forbidden"
                    },
                    "404": {
                        "description": "Not Found"
                    }
                },
                "deprecated": false
            }
        },
        "/food/GetFoodPage/{CurrentPage}/{PageSize}": {
            "get": {
                "tags": [
                    "food-controller"
                ],
                "summary": "GetFoodPage",
                "operationId": "GetFoodPageUsingGET",
                "produces": [
                    "*/*"
                ],
                "parameters": [
                    {
                        "name": "CurrentPage",
                        "in": "path",
                        "description": "CurrentPage",
                        "required": true,
                        "type": "integer",
                        "format": "int32"
                    },
                    {
                        "name": "PageSize",
                        "in": "path",
                        "description": "PageSize",
                        "required": true,
                        "type": "integer",
                        "format": "int32"
                    }
                ],
                "responses": {
                    "200": {
                        "description": "OK",
                        "schema": {
                            "type": "array",
                            "items": {
                                "$ref": "#/definitions/Food"
                            }
                        }
                    },
                    "401": {
                        "description": "Unauthorized"
                    },
                    "403": {
                        "description": "Forbidden"
                    },
                    "404": {
                        "description": "Not Found"
                    }
                },
                "deprecated": false
            }
        },
        "/food/UpdateFood": {
            "post": {
                "tags": [
                    "food-controller"
                ],
                "summary": "UpdateFood",
                "operationId": "UpdateFoodUsingPOST",
                "consumes": [
                    "application/json"
                ],
                "produces": [
                    "*/*"
                ],
                "responses": {
                    "200": {
                        "description": "OK",
                        "schema": {
                            "$ref": "#/definitions/Food"
                        }
                    },
                    "201": {
                        "description": "Created"
                    },
                    "401": {
                        "description": "Unauthorized"
                    },
                    "403": {
                        "description": "Forbidden"
                    },
                    "404": {
                        "description": "Not Found"
                    }
                },
                "deprecated": false
            }
        },
        "/user/AddUser": {
            "post": {
                "tags": [
                    "user-controller"
                ],
                "summary": "AddUser",
                "operationId": "AddUserUsingPOST",
                "consumes": [
                    "application/json"
                ],
                "produces": [
                    "*/*"
                ],
                "responses": {
                    "200": {
                        "description": "OK",
                        "schema": {
                            "$ref": "#/definitions/User"
                        }
                    },
                    "201": {
                        "description": "Created"
                    },
                    "401": {
                        "description": "Unauthorized"
                    },
                    "403": {
                        "description": "Forbidden"
                    },
                    "404": {
                        "description": "Not Found"
                    }
                },
                "deprecated": false
            }
        },
        "/user/DeleteUserById/{id}": {
            "delete": {
                "tags": [
                    "user-controller"
                ],
                "summary": "DeleteUserById",
                "operationId": "DeleteUserByIdUsingDELETE",
                "produces": [
                    "*/*"
                ],
                "parameters": [
                    {
                        "name": "id",
                        "in": "path",
                        "description": "id",
                        "required": true,
                        "type": "integer",
                        "format": "int32"
                    }
                ],
                "responses": {
                    "200": {
                        "description": "OK",
                        "schema": {
                            "$ref": "#/definitions/User"
                        }
                    },
                    "204": {
                        "description": "No Content"
                    },
                    "401": {
                        "description": "Unauthorized"
                    },
                    "403": {
                        "description": "Forbidden"
                    }
                },
                "deprecated": false
            }
        },
        "/user/GetAllUser": {
            "get": {
                "tags": [
                    "user-controller"
                ],
                "summary": "GetAllUser",
                "operationId": "GetAllUserUsingGET",
                "produces": [
                    "*/*"
                ],
                "responses": {
                    "200": {
                        "description": "OK",
                        "schema": {
                            "type": "array",
                            "items": {
                                "$ref": "#/definitions/User"
                            }
                        }
                    },
                    "401": {
                        "description": "Unauthorized"
                    },
                    "403": {
                        "description": "Forbidden"
                    },
                    "404": {
                        "description": "Not Found"
                    }
                },
                "deprecated": false
            }
        },
        "/user/GetUserById/{id}": {
            "get": {
                "tags": [
                    "user-controller"
                ],
                "summary": "GetUserById",
                "operationId": "GetUserByIdUsingGET",
                "produces": [
                    "*/*"
                ],
                "parameters": [
                    {
                        "name": "id",
                        "in": "path",
                        "description": "id",
                        "required": true,
                        "type": "integer",
                        "format": "int32"
                    }
                ],
                "responses": {
                    "200": {
                        "description": "OK",
                        "schema": {
                            "$ref": "#/definitions/User"
                        }
                    },
                    "401": {
                        "description": "Unauthorized"
                    },
                    "403": {
                        "description": "Forbidden"
                    },
                    "404": {
                        "description": "Not Found"
                    }
                },
                "deprecated": false
            }
        },
        "/user/GetUserByName/{name}": {
            "get": {
                "tags": [
                    "user-controller"
                ],
                "summary": "GetUserByName",
                "operationId": "GetUserByNameUsingGET",
                "produces": [
                    "*/*"
                ],
                "parameters": [
                    {
                        "name": "name",
                        "in": "path",
                        "description": "name",
                        "required": true,
                        "type": "string"
                    }
                ],
                "responses": {
                    "200": {
                        "description": "OK",
                        "schema": {
                            "type": "array",
                            "items": {
                                "$ref": "#/definitions/User"
                            }
                        }
                    },
                    "401": {
                        "description": "Unauthorized"
                    },
                    "403": {
                        "description": "Forbidden"
                    },
                    "404": {
                        "description": "Not Found"
                    }
                },
                "deprecated": false
            }
        },
        "/user/GetUserPage/{CurrentPage}/{PageSize}": {
            "get": {
                "tags": [
                    "user-controller"
                ],
                "summary": "GetUserPage",
                "operationId": "GetUserPageUsingGET",
                "produces": [
                    "*/*"
                ],
                "parameters": [
                    {
                        "name": "CurrentPage",
                        "in": "path",
                        "description": "CurrentPage",
                        "required": true,
                        "type": "integer",
                        "format": "int32"
                    },
                    {
                        "name": "PageSize",
                        "in": "path",
                        "description": "PageSize",
                        "required": true,
                        "type": "integer",
                        "format": "int32"
                    }
                ],
                "responses": {
                    "200": {
                        "description": "OK",
                        "schema": {
                            "type": "array",
                            "items": {
                                "$ref": "#/definitions/User"
                            }
                        }
                    },
                    "401": {
                        "description": "Unauthorized"
                    },
                    "403": {
                        "description": "Forbidden"
                    },
                    "404": {
                        "description": "Not Found"
                    }
                },
                "deprecated": false
            }
        },
        "/user/Redo": {
            "get": {
                "tags": [
                    "user-controller"
                ],
                "summary": "RedoUser",
                "operationId": "RedoUserUsingGET",
                "produces": [
                    "*/*"
                ],
                "responses": {
                    "200": {
                        "description": "OK",
                        "schema": {
                            "type": "string"
                        }
                    },
                    "401": {
                        "description": "Unauthorized"
                    },
                    "403": {
                        "description": "Forbidden"
                    },
                    "404": {
                        "description": "Not Found"
                    }
                },
                "deprecated": false
            }
        },
        "/user/UpdateUser": {
            "post": {
                "tags": [
                    "user-controller"
                ],
                "summary": "UpdateUser",
                "operationId": "UpdateUserUsingPOST",
                "consumes": [
                    "application/json"
                ],
                "produces": [
                    "*/*"
                ],
                "responses": {
                    "200": {
                        "description": "OK",
                        "schema": {
                            "$ref": "#/definitions/User"
                        }
                    },
                    "201": {
                        "description": "Created"
                    },
                    "401": {
                        "description": "Unauthorized"
                    },
                    "403": {
                        "description": "Forbidden"
                    },
                    "404": {
                        "description": "Not Found"
                    }
                },
                "deprecated": false
            }
        }
    },
    "definitions": {
        "Canteen": {
            "type": "object",
            "properties": {
                "id": {
                    "type": "integer",
                    "format": "int32"
                },
                "name": {
                    "type": "string"
                },
                "position": {
                    "type": "string"
                }
            },
            "title": "Canteen"
        },
        "Comment": {
            "type": "object",
            "properties": {
                "canteen": {
                    "type": "string"
                },
                "content": {
                    "type": "string"
                },
                "food_name": {
                    "type": "string"
                },
                "id": {
                    "type": "integer",
                    "format": "int32"
                },
                "stars": {
                    "type": "integer",
                    "format": "int32"
                },
                "user_id": {
                    "type": "integer",
                    "format": "int32"
                }
            },
            "title": "Comment"
        },
        "Food": {
            "type": "object",
            "properties": {
                "canteen": {
                    "type": "string"
                },
                "id": {
                    "type": "integer",
                    "format": "int32"
                },
                "img_url": {
                    "type": "string"
                },
                "name": {
                    "type": "string"
                }
            },
            "title": "Food"
        },
        "User": {
            "type": "object",
            "properties": {
                "author_level": {
                    "type": "integer",
                    "format": "int32"
                },
                "faculty": {
                    "type": "string"
                },
                "headimg_url": {
                    "type": "string"
                },
                "id": {
                    "type": "integer",
                    "format": "int32"
                },
                "name": {
                    "type": "string"
                },
                "school_num": {
                    "type": "string"
                }
            },
            "title": "User"
        }
    }
}