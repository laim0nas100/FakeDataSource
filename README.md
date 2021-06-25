
Fake Data Source

Standalone library (0 dependencies) to fill DataSource interface tree as much as it is possible without throwing exceptions while not actually doing anything, while not being NOP (no operation) implementation.
As long as your use case does not invoke actual SQL commands, this should suffice.

Useful to quickly fill dependencies in DI application (usually Spring based) that requires a DataSource to be initialized, but does not actually use it for whatever reason.

[![](https://jitpack.io/v/laim0nas100/SimpleSpringContext.svg)](https://jitpack.io/#laim0nas100/FakeDataSource)
