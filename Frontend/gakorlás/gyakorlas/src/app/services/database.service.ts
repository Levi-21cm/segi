import { Injectable } from '@angular/core';
import { MongoClient } from 'mongodb';

@Injectable({
  providedIn: 'root'
})
export class DatabaseService {
  private url: string = 'mongodb://localhost:27017'; // A MongoDB szerver URL-je
  private dbName: string = 'mydatabase'; // Az adatbázis neve
  private client: MongoClient;
  private db;

  constructor() {
    this.client = new MongoClient(this.url);
    this.client.connect((err) => {
      if (err) {
        console.error('Hiba a MongoDB kapcsolódásakor:', err);
        return;
      }
      console.log('Sikeres MongoDB kapcsolódás');
      this.db = this.client.db(this.dbName);
    });
  }
}
