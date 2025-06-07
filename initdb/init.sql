CREATE TABLE IF NOT EXISTS users (
  id SERIAL PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  email VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS stores (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS sales (
  id SERIAL PRIMARY KEY,
  user_id INT NOT NULL,
  store_id INT NOT NULL,
  total_amount DECIMAL(10, 2) NOT NULL,
  date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (user_id) REFERENCES users(id),
  FOREIGN KEY (store_id) REFERENCES stores(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS products (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price DOUBLE PRECISION NOT NULL
);

CREATE TABLE IF NOT EXISTS sales_products (
    sale_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL,
    sub_total DOUBLE PRECISION NOT NULL,
    PRIMARY KEY (sale_id, product_id),
    FOREIGN KEY (sale_id) REFERENCES sales(id) ON DELETE CASCADE,
    FOREIGN KEY (product_id) REFERENCES products(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS returns (
    id SERIAL PRIMARY KEY,
    sale_id INT NOT NULL,
    user_id INT NOT NULL,
    date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    total_amount DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (sale_id) REFERENCES sales(id) ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
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

CREATE TABLE IF NOT EXISTS store_inventory (
    id SERIAL PRIMARY KEY,
    store_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL,
    min_threshold INT NOT NULL,
    max_threshold INT,
    FOREIGN KEY (store_id) REFERENCES stores(id) ON DELETE CASCADE,
    FOREIGN KEY (product_id) REFERENCES products(id) ON DELETE CASCADE,
    UNIQUE (store_id, product_id)
);

CREATE TABLE IF NOT EXISTS store_sales_metrics (
    id SERIAL PRIMARY KEY,
    store_id INT NOT NULL UNIQUE,
    total_sales DECIMAL(15, 2) DEFAULT 0,
    weekly_sales DECIMAL(15, 2) DEFAULT 0,
    FOREIGN KEY (store_id) REFERENCES stores(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS store_product_metrics (
    id SERIAL PRIMARY KEY,
    store_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity_sold INT DEFAULT 0,
    revenue DECIMAL(10, 2) DEFAULT 0,
    FOREIGN KEY (store_id) REFERENCES stores(id) ON DELETE CASCADE,
    FOREIGN KEY (product_id) REFERENCES products(id) ON DELETE CASCADE,
    UNIQUE (store_id, product_id)
);

CREATE TABLE IF NOT EXISTS logistics_centers (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS logistics_center_inventory (
    id SERIAL PRIMARY KEY,
    logistics_center_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL,
    FOREIGN KEY (logistics_center_id) REFERENCES logistics_centers(id) ON DELETE CASCADE,
    FOREIGN KEY (product_id) REFERENCES products(id) ON DELETE CASCADE,
    UNIQUE (logistics_center_id, product_id)
);

CREATE TABLE IF NOT EXISTS supply_requests (
    id SERIAL PRIMARY KEY,
    store_id INT NOT NULL,
    logistics_center_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity_requested INT NOT NULL,
    status VARCHAR(20) NOT NULL CHECK (status IN ('PENDING', 'APPROVED', 'DELIVERED', 'REJECTED', 'CANCELLED')),
    FOREIGN KEY (store_id) REFERENCES stores(id),
    FOREIGN KEY (logistics_center_id) REFERENCES logistics_centers(id),
    FOREIGN KEY (product_id) REFERENCES products(id) ON DELETE CASCADE
);


INSERT INTO users (name, email) VALUES
('Alice Smith', 'alice@example.com'),
('Bob Jones', 'bob@example.com'),
('Carol Wilson', 'carol@example.com')
ON CONFLICT (id) DO NOTHING;

INSERT INTO product_categories (name) VALUES
('Electronics'),
('Books'),
('Clothing')
ON CONFLICT (id) DO NOTHING;

INSERT INTO products (name, price) VALUES
('Laptop', 1200.00),
('T-Shirt', 20.00),
('Novel', 15.50)
ON CONFLICT (id) DO NOTHING;

INSERT INTO products_product_categories (product_id, category_id) VALUES
(1, 1), -- Laptop is Electronics
(2, 3), -- T-Shirt is Clothing
(3, 2) -- Novel is Books
ON CONFLICT (product_id, category_id) DO NOTHING;

INSERT INTO stores (name) VALUES
('Store A'),
('Store B')
ON CONFLICT (id) DO NOTHING;

INSERT INTO sales (user_id, store_id, total_amount, date) VALUES
(1, 1, 1240.00, '2024-03-01 10:00:00'),
(2, 1, 835.50, '2024-03-02 11:30:00'),
(3, 2, 2400.00, '2024-03-03 14:15:00')
ON CONFLICT (id) DO NOTHING;

INSERT INTO sales_products (sale_id, product_id, quantity, sub_total) VALUES
(1, 1, 1, 1200.00),
(1, 2, 2, 40.00),
(2, 3, 1, 15.50),
(3, 1, 2, 2400.00)
ON CONFLICT (sale_id, product_id) DO NOTHING;

INSERT INTO store_inventory (store_id, product_id, quantity, min_threshold, max_threshold) VALUES
(1, 1, 3, 5, 25),
(1, 2, 50, 20, 45),
(1, 3, 30, 15, 40),
(2, 1, 8, 5, 30),
(2, 2, 20, 10, 50),
(2, 3, 15, 5, 25)
ON CONFLICT (store_id, product_id) DO NOTHING;

INSERT INTO store_product_metrics (store_id, product_id, quantity_sold, revenue) VALUES
(1, 1, 5, 6000.00),
(1, 2, 100, 2000.00),
(2, 1, 3, 3600.00),
(2, 3, 10, 155.00)
ON CONFLICT (store_id, product_id) DO NOTHING;

INSERT INTO logistics_centers (name) VALUES
('Distribution Center')
ON CONFLICT (id) DO NOTHING;

INSERT INTO logistics_center_inventory (logistics_center_id, product_id, quantity) VALUES
(1, 1, 100),
(1, 2, 200),
(1, 3, 150)
ON CONFLICT (logistics_center_id, product_id) DO NOTHING;

INSERT INTO store_sales_metrics (store_id, total_sales, weekly_sales) VALUES
(1, 8000.00, 2000.00),  -- Store A total and weekly sales
(2, 11600.00, 3000.00)  -- Store B total and weekly sales
ON CONFLICT (store_id) DO NOTHING;