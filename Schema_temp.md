
# RDB
## Users
- long userId
- string userName
- string identifier
- string password
- string email

## Products
- long productId
- string productName
- int price
- string shopName


## ProductOptions
- long productOptionId
- string productOptionName
- int stockQuantity

## Shop
- long shopId
- string shopName


## Orders
- long orderId
- long userId
- long productId
- long productOptionId
- string productName
- string shopName
- int price
- int quantity;
- string productOptionName


## Payments
- long paymentId
- long userId
- long productId
- long productOptionId
- long shopId


# MongoDB
## Carts
- long userId
- List<Long> productIds
  

