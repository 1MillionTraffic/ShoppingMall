
# RDB
## 유저 DB
### Users
- long userId
- string userName
- string identifier
- string password
- string email

---
## 상품 DB
### Products
- long productId
- string productName
- int price
- string shopName


### ProductOptions
- long productOptionId
- string productOptionName
- int stockQuantity

### Shop
- long shopId
- string shopName

---
## billing DB (샤딩 필요)
### Orders
- long orderId
- long userId
- long productId
- long productOptionId
- string productName
- string shopName
- int price
- int quantity;
- string productOptionName

### Payments
- long paymentId
- long userId
- long productId
- long productOptionId
- long shopId

### Coupons
- long id

### CouponsMap
- long id
- long userId
- long couponId

### Mileages
---
## 댓글/리뷰 DB
### Review

### Comment

---

# MongoDB
## 장바구니
### Carts
- long userId
- List<Long> productIds
  

