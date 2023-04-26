
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

### Coupons
- long couponId

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

### Mileages
- long mileageId

### CouponsMap
- long couponsMapid
- long userId
- long couponId

---
## 리뷰 DB
### Reviews
- long reviewId
- int rating
- string description
- long productId
- string imageUrl

### ReviewTags
- long reviewTagId
- long reviewId

---

# MongoDB
## 장바구니
### Carts
- long userId
- List<Long> productIds
