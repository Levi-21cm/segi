const express = require("express");
const tortaRouter = require("./routers/tortaRouter")

const app = express()

app.use(express.json())

app.use("/api/v1/torta", tortaRouter)

module.exports = app;