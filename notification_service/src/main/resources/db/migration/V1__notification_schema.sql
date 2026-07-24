CREATE TABLE IF NOT EXISTS notifications (
    id uuid PRIMARY KEY,
    receiver_id uuid NOT NULL,
    receiver_type varchar(32) NOT NULL,
    title varchar(160) NOT NULL,
    message varchar(4000) NOT NULL,
    notification_type varchar(64) NOT NULL,
    delivery_channel varchar(32) NOT NULL,
    notification_status varchar(32) NOT NULL,
    reference_id uuid NOT NULL,
    created_at timestamp NOT NULL,
    sent_at timestamp,
    read_at timestamp
);
CREATE INDEX IF NOT EXISTS idx_notifications_receiver_created ON notifications(receiver_id, created_at DESC);
CREATE INDEX IF NOT EXISTS idx_notifications_reference_type ON notifications(reference_id, notification_type);
CREATE TABLE IF NOT EXISTS notification_logs (
    id uuid PRIMARY KEY,
    channel varchar(32) NOT NULL,
    status varchar(32) NOT NULL,
    response_message varchar(2000),
    retry_count integer NOT NULL DEFAULT 0,
    created_at timestamp NOT NULL,
    notification_id uuid REFERENCES notifications(id)
);
