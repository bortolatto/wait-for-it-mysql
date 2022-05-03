# Test data: admin password is 12345
INSERT IGNORE INTO user (username, password, algorithm) VALUES ('john', '$2a$12$Dhf5gHy6KS9LWcB80VvGYe4HY5dxxHJjWU.5No4zak3uwzhNi8wFG', 'BCRYPT');

INSERT IGNORE INTO authority (name, user) VALUES ('READ', '1');
INSERT IGNORE INTO authority (name, user) VALUES ('WRITE', '1');

INSERT IGNORE INTO product (name, price, currency) VALUES ('Chocolate', '10', 'USD');