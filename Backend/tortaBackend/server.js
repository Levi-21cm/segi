const mongoose = require('mongoose')

const app = require('./app')

const DB = "mongodb://localhost:27017/torta"

mongoose.connect(DB, {
    useNewUrlParser: true
})
.then(() => console.log('Az adatbáziska csatizott'))

const port = 3001

app.listen(port, ()=>{
    console.log('az adatbázis a 3000 portoton fut')
})