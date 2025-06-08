import axios from 'axios';

/**
 * Reuse the axios instance directly to simplify testing.
 * Setting the baseURL on the default instance avoids the need
 * for axios.create which isn't mocked in the tests.
 */
axios.defaults.baseURL = 'http://localhost:8080/api';

export default axios;
