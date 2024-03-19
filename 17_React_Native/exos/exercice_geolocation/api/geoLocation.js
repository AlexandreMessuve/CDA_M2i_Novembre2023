import axios from "axios"
import { GEO_POSITION_URL } from "../constants/URL";
import { API_KEY } from "../constants/apiKey";

export const fetchGeoposition = async(latitude, longitude) => {
    try {
        const response = await axios.get(GEO_POSITION_URL+`apikey=${API_KEY}&q=${latitude},${longitude}`);
        return response.data
    } catch (error) {
        console.log(error);
    }
}