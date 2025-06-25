import http from 'k6/http';
import { sleep, fail, check } from 'k6';
import encoding from 'k6/encoding';


export let options = {
  stages: [
    { duration: '1m', target: 100 },
    { duration: '1m', target: 200 },
    { duration: '1m', target: 400 },
    { duration: '1m', target: 800 },
    { duration: '30s', target: 0 },  // descente rapide
  ],
};


/*export let options = {
  stages: [
    { duration: '20s', target: 200 },
    //{ duration: '3m', target: 50 },
    //{ duration: '1m', target: 0 },
  ],
};*/

const username = 'log430';
const password = 'log430';
const credentials = `${username}:${password}`;
const encodedCredentials = encoding.b64encode(credentials);
// Encodage des identifiants pour l'authentification Basic
export default function () {
  const url = 'http://localhost:8080/api/v1/stores/1/stock';

  const params = {
    headers: {
      Authorization: `Basic ${encodedCredentials}`,
    },
  };

  const res = http.get(url, params);

  const ok = check(res, {
    'status is 200': (r) => r.status === 200,
    'response time < 500ms': (r) => r.timings.duration < 500,
  });

  if (!ok) {
    fail(`Test failed: status=${res.status} duration=${res.timings.duration}`);
  }

  sleep(1);
}