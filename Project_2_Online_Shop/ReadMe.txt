
1. Managing.Product
Variables: id, name, price, description, category, stockQuantity
Constructor: Managing.Product(id, name, price, description, category, stockQuantity)
Methods:


isAvailable()


applyDiscount(percent)


updatePrice(newPrice)


reduceStock(quantity)


increaseStock(quantity)



2. Managing.Customer
Variables: id, name, email, password, address, wishlist(List<Managing.Product>), orderHistory(List<Managing.Order>)
Constructor: Managing.Customer(id, name, email, password, address)
Methods:


login(email, password)


logout()


addToWishlist(product)


removeFromWishlist(product)


updateAddress(newAddress)


viewOrders()



3. Managing.Order
Variables: id, customer, items(Map<Managing.Product, quantity>), totalPrice, status, paymentStatus, date
Constructor: Managing.Order(id, customer)
Methods:


addProduct(product, quantity)


removeProduct(product)


calculateTotal()


changeStatus(status)


setPaymentStatus(status)



4. Managing.ShoppingCart
Variables: id, customer, items(Map<Managing.Product, quantity>), totalCost
Constructor: Managing.ShoppingCart(customer)
Methods:


addItem(product, quantity)


removeItem(product)


updateQuantity(product, quantity)


calculateTotal()


emptyCart()


validateStock()



5. Payment.Payment
Variables: id, order, amount, method, status, transactionId
Constructor: Payment.Payment(id, order, amount, method)
Methods:


processPayment()


refundPayment()


isPaymentSuccessful()


updateStatus(status)



6. Shipping
Variables: id, order, address, shippingType, cost, status, trackingNumber
Constructor: Shipping(id, order, address, shippingType)
Methods:


calculateShippingCost()


generateTrackingNumber()


updateShippingStatus(status)


estimateDeliveryDate()

