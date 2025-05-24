CREATE TABLE IF NOT EXISTS users (
  id SERIAL PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  email VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS sales (
  id SERIAL PRIMARY KEY,
  user_id INT NOT NULL,
  total_amount DECIMAL(10, 2) NOT NULL,
  date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE IF NOT EXISTS products (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price DOUBLE PRECISION NOT NULL,
    stock_quantity INT NOT NULL
);

CREATE TABLE IF NOT EXISTS sales_products (
    sale_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL,
    PRIMARY KEY (sale_id, product_id),
    FOREIGN KEY (sale_id) REFERENCES sales(id) ON DELETE CASCADE,
    FOREIGN KEY (product_id) REFERENCES products(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS product_categories (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS products_product_categories (
    product_id INT NOT NULL,
    category_id INT NOT NULL,
    PRIMARY KEY (product_id, category_id),
    FOREIGN KEY (product_id) REFERENCES products(id) ON DELETE CASCADE,
    FOREIGN KEY (category_id) REFERENCES product_categories(id) ON DELETE CASCADE
);

INSERT INTO users (name, email) VALUES
('Alice Smith', 'alice@example.com'),
('Bob Jones', 'bob@example.com')
ON CONFLICT (id) DO NOTHING;

INSERT INTO product_categories (name) VALUES
('Electronics'),
('Books'),
('Clothing')
ON CONFLICT (id) DO NOTHING;

INSERT INTO products (name, price, stock_quantity) VALUES
('Laptop', 1200.00, 10),
('T-Shirt', 20.00, 50),
('Novel', 15.50, 30)
ON CONFLICT (id) DO NOTHING;

INSERT INTO sales (user_id, total_amount) VALUES
(1, 1240.00),
(2, 35.50)
ON CONFLICT (id) DO NOTHING;

INSERT INTO sales_products (sale_id, product_id, quantity) VALUES
(1, 1, 1),  -- Alice bought 1 Laptop
(1, 2, 2),  -- Alice bought 2 T-Shirts
(2, 3, 2)  -- Bob bought 2 Novels
ON CONFLICT (sale_id, product_id) DO NOTHING;

INSERT INTO products_product_categories (product_id, category_id) VALUES
(1, 1), -- Laptop is Electronics
(2, 3), -- T-Shirt is Clothing
(3, 2) -- Novel is Books
ON CONFLICT (product_id, category_id) DO NOTHING;