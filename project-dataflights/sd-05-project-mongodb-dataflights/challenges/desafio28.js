db.resumoVoos.insertOne({
    "empresa":"LATAM AIRLINES BRASIL",
    "totalVoosDomesticos":
    db.voos.count({
        $and: [
            {"natureza": "Doméstica"},
            {"empresa.nome": "LATAM AIRLINES BRASIL"}
        ]})
    }
);
db.resumoVoos.findOne({"empresa":"LATAM AIRLINES BRASIL"}, {"_id":0});
