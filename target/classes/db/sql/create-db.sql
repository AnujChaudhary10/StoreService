DROP TABLE products IF EXISTS;

CREATE TABLE promotions (
  promotion_id   INTEGER PRIMARY KEY,
  promotion_name VARCHAR(100),
  promotion_type  VARCHAR(30),
  distcount_percentage INTEGER,
  validity Date
);

CREATE TABLE stores (
  store_id   INTEGER PRIMARY KEY,
  store_name VARCHAR(100),
  store_type  VARCHAR(30),
  longitude VARCHAR(50),
  latitude VARCHAR(50),
  address VARCHAR(100),
  phoneNumber VARCHAR(12)
);

