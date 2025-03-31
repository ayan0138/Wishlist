-- testformål maksimal funktionalitet (tilknytning af alle produkter til alle brugere)
INSERT INTO Wishlist_Product (wishlist_id, product_id)
SELECT w.wishlist_id, p.product_id
FROM Wishlist w, Pruduct p;
