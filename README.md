# This project has all type of relationship demo

Post http://localhost:8080/team   

{  
    "name": "My team",  
    "players": [  
        {  
            "name": "mahi",  
            "age": 2  
        },  
        {  
            "name": "masum",  
            "age": 36  
        {  
            "name": "soma",  
            "age": 32  
        }  
    ],    
    "score": {  
        "point": 100  
    }  
}  

post http://localhost:8080/player  

{  
    "name": "masi",  
    "age": 30,  
    "team": {  
       "name": "xx team"  
    }    
}  

Post http://localhost:8080/venue  

{  
    "name": "venue name",  
    "address": "venue address",  
    "capacity": 5000,  
    "scores": [  
        {  
         "point": 20  
        },  
        {  
         "point": 40  
        }  
     ]     
}  


