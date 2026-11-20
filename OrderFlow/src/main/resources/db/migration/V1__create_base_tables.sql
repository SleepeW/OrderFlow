CREATE TABLE "users" (
  "id" integer PRIMARY KEY,
  "username" varchar NOT NULL,
  "role" integer NOT NULL,
  "balance" integer NOT NULL DEFAULT 0
);

CREATE TABLE "orders" (
  "id" integer PRIMARY KEY,
  "user_id" integer NOT NULL,
  "created_at" timestamp NOT NULL,
  "status" integer NOT NULL,
  "total_price" integer NOT NULL CHECK (total_price >= 0)
);

CREATE TABLE "order_items" (
  "id" integer PRIMARY KEY,
  "order_id" integer NOT NULL,
  "product_id" integer NOT NULL,
  "count" integer NOT NULL CHECK (count > 0),
  "unit_price" integer NOT NULL CHECK (unit_price >= 0)
);

CREATE TABLE "products" (
  "id" integer PRIMARY KEY,
  "owner_user_id" integer NOT NULL,
  "name" varchar NOT NULL,
  "description" varchar,
  "price" integer NOT NULL CHECK (price >= 0)
);

CREATE TABLE "storages" (
  "id" integer PRIMARY KEY,
  "name" varchar NOT NULL
);

CREATE TABLE "storage_items" (
  "id" integer PRIMARY KEY,
  "storage_id" integer NOT NULL,
  "product_id" integer NOT NULL,
  "count" integer NOT NULL CHECK (count > 0),
  "reserv" integer NOT NULL CHECK (reserv >= 0)
);

ALTER TABLE "orders" ADD FOREIGN KEY ("user_id") REFERENCES "users" ("id") DEFERRABLE INITIALLY IMMEDIATE;

ALTER TABLE "products" ADD FOREIGN KEY ("owner_user_id") REFERENCES "users" ("id") DEFERRABLE INITIALLY IMMEDIATE;

ALTER TABLE "order_items" ADD FOREIGN KEY ("order_id") REFERENCES "orders" ("id") DEFERRABLE INITIALLY IMMEDIATE;

ALTER TABLE "order_items" ADD FOREIGN KEY ("product_id") REFERENCES "products" ("id") DEFERRABLE INITIALLY IMMEDIATE;

ALTER TABLE "storage_items" ADD FOREIGN KEY ("product_id") REFERENCES "products" ("id") DEFERRABLE INITIALLY IMMEDIATE;

ALTER TABLE "storage_items" ADD FOREIGN KEY ("storage_id") REFERENCES "storages" ("id") DEFERRABLE INITIALLY IMMEDIATE;
