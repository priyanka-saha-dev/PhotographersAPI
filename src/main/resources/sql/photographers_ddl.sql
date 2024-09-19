CREATE TABLE PHOTOGRAPHER (
    id INT PRIMARY KEY auto_increment,
    uid UUID UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    username VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    avatar VARCHAR(255),
    gender VARCHAR(100),
    phone_number VARCHAR(50),
    social_insurance_number VARCHAR(50),
    date_of_birth DATE,
    address_id INT, -- Foreign key to Address
    credit_card_id INT, -- Foreign key to Credit Card
    subscription_id INT, -- Foreign key to Subscription
    FOREIGN KEY (address_id) REFERENCES ADDRESS(id),
    FOREIGN KEY (credit_card_id) REFERENCES CREDIT_CARD(id),
    FOREIGN KEY (subscription_id) REFERENCES SUBSCRIPTION(id)
);

CREATE TABLE EVENT_TYPES(
    id INT PRIMARY KEY auto_increment,
    event VARCHAR(100) NOT NULL
);
CREATE UNIQUE INDEX PK_EVENT_TYPES ON EVENT_TYPES(event);

CREATE TABLE PHOTOGRAPHER_EVENT_TYPES(
    photographer_id INT,
    event_type_id INT,
    PRIMARY KEY(photographer_id, event_type_id),
    FOREIGN KEY (event_type_id) REFERENCES EVENT_TYPES(id),
    FOREIGN KEY (photographer_id) REFERENCES PHOTOGRAPHER(id)
);

CREATE TABLE ADDRESS(
    id INT PRIMARY KEY auto_increment,
    city VARCHAR(100) NOT NULL,
    street_name VARCHAR(100) NOT NULL,
    street_address VARCHAR(100) NOT NULL,
    zip_code VARCHAR(100) NOT NULL,
    state VARCHAR(100) NOT NULL,
    country VARCHAR(255),
    coordinates_lat DECIMAL(10, 6),
    coordinates_lng DECIMAL(10, 6)
);

CREATE TABLE CREDIT_CARD (
    id INT PRIMARY KEY auto_increment,
    cc_number VARCHAR(100) NOT NULL
);

CREATE TABLE SUBSCRIPTION (
    id INT PRIMARY KEY auto_increment,
    plan VARCHAR(100) NOT NULL,
    status VARCHAR(100) NOT NULL,
    payment_method VARCHAR(100) NOT NULL,
    term VARCHAR(100) NOT NULL
);

