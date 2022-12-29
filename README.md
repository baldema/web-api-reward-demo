## Reward Points Calculator
This repository contains a Spring Boot application that calculates reward points for a retailer's customers based on their recorded purchases.

### Requirements
- Java 11 or later
- Maven

### Running the Application
To run the application, navigate to the root directory of the project and run the following command:

```mvn spring-boot:run```

The application will start up on port 8080.

### API
The application has a single API endpoint, `POST /rewards`, which accepts a list of transactions as input and returns the reward points earned by each customer per month and the total reward points earned by each customer.

The request body should be in the following format:

```agsl
{
  "transactions": [
    {
      "customerId": 1,
      "amount": 120,
      "date": "2022-01-15"
    },
    {
      "customerId": 1,
      "amount": 80,
      "date": "2022-02-05"
    },
    {
      "customerId": 2,
      "amount": 100,
      "date": "2022-03-10"
    },
    {
      "customerId": 2,
      "amount": 200,
      "date": "2022-03-15"
    }
  ]
}

```
The response will be in the following format:

```agsl
[
    {
        "customerId": 1,
        "rewardPointsList": [
            {
                "month": "February",
                "points": 30.0
            },
            {
                "month": "January",
                "points": 110.0
            }
        ],
        "totalRewardPoints": 140.0
    },
    {
        "customerId": 2,
        "rewardPointsList": [
            {
                "month": "March",
                "points": 400.0
            }
        ],
        "totalRewardPoints": 400.0
    }
]
```
### License
This project is licensed under the MIT License.