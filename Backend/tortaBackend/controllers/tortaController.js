const torta =  require("../models/tortaModel")
exports.creatTorta = async (req,res) => {
    try {
        const newTorta = await torta.create(req.body)

        res.status(200).json({
            suces: "sikeres létrehozás"
        })
    } catch (e) {
        res.status(400).json({
            error:"hiba"
        })
    }
}
exports.getAllTorta = async (req,res) => {
    try {
        const osszes = await torta.find()

        res.status(200).json({
            torta: osszes
        })

    
    } catch (e) {
        res.status(400).json({
            error: "hiba"
        })    
    }
}
exports.getTortabyId = async (req,res) => {
    try {
        const ids = await torta.findById(req.params.id)

        res.status(200).json({
            torta: ids
        })
    } catch (error) {
        res.status(400).json({
             error: "hiba"
        })
    }
}
exports.updateTorta = async (req,res) =>{
    try {
        const modosit = await torta.findByIdAndUpdate(req.params.id, req.body)
        
        
        res.status(200).json({
            torta: modosit
        })
    } catch (error) {
        res.status(400).json({
            error: "hiba"
       })
    }
}
exports.deleteTorta = async (req,res) =>{
    try {

        const torol = await torta.findByIdAndDelete(req.params.id)
    
        res.status(200).json({
            torta: "sikeres tőrles"
        })
    } catch (error) {
        res.status(400).json({
            error: "hiba"
       })
    }
}