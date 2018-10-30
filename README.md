## Build with lombok + errorprone + buck

- `./buckw build //vanilla/... --config java.jar_spool_mode=intermediate_to_disk` (works)

- `./buckw build //vanilla/... --config java.jar_spool_mode=direct_to_jar` (fails)
