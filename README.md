# Decola Tech 2025
#JAVA RESTFUL API

## Diagrama de Classes

````mermaid
classDiagram
    class User {
        +String name
        +Account account
        +List~Feature~ features
        +Card card
        +List~News~ news
    }
    class Account {
        - number : String
        - agency : String
        - balance : Double
        - limit : Double
        + getNumber() : String
        + getAgency() : String
        + getBalance() : Double
        + getLimit() : Double
    }
    class Feature {
        - icon : String
        - description : String
        + getIcon() : String
        + getDescription() : String
    }
    class Card {
        - number : String
        - limit : Double
        + getNumber() : String
        + getLimit() : Double
    }
    class News {
        - icon : String
        - description : String
        + getIcon() : String
        + getDescription() : String
    }
    User "1" -- "1" Account : possui
    User "1" -- "N" Feature : possui
    User "1" -- "1" Card : possui
    User "1" -- "N" News : possui
````
