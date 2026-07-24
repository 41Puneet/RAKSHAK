CREATE TABLE IF NOT EXISTS users (
    id uuid PRIMARY KEY,
    full_name varchar(100) NOT NULL,
    email varchar(150) NOT NULL UNIQUE,
    phone_number varchar(15) NOT NULL UNIQUE,
    password_hash varchar(255) NOT NULL,
    role varchar(64) NOT NULL,
    account_status varchar(32) NOT NULL,
    profile_image_url varchar(500),
    device_token varchar(512),
    created_at timestamp,
    updated_at timestamp
);
CREATE TABLE IF NOT EXISTS "refresh-token" (
    id uuid PRIMARY KEY,
    token varchar(255) NOT NULL UNIQUE,
    user_id uuid NOT NULL,
    expiry_date timestamp,
    revoked boolean NOT NULL DEFAULT false,
    created_at timestamp
);
