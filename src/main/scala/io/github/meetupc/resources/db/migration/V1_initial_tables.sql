DROP TABLE IF EXISTS "meetup";

CREATE TABLE IF NOT EXISTS "meetup" (
  id UUID PRIMARY KEY,
  "name" VARCHAR(80) NOT NULL,
  attendants INTEGER NOT NULL,
  "date" NUMERIC(22,0) NOT NULL, -- TODO look for appropiate date type for Instant
);