import { ActivityIndicator, Pressable, StyleSheet, Text, View } from 'react-native'
import React, { useEffect, useState } from 'react'
import Geolocation from '@react-native-community/geolocation'
import { fetchGeoposition } from './api/geoLocation';

const App = () => {
    const [coord, setCoord] = useState({});
    const [latitude, setLatitude] = useState('');
    const [longitude, setLongitude] = useState('');
    const [loader, setLoader] = useState(true);
    useEffect(() => {
        Geolocation.requestAuthorization();
        Geolocation.getCurrentPosition(position => {
            setLatitude(position.coords.latitude)
            setLongitude(position.coords.longitude),
                error => console.log(error),
                { enableHighAccuracy: true, timeout: 20000, maximumAge: 1000 }
        });
    }, []);

    const getCoords = async () => {
        setLoader(true)
        try {
            const data = await fetchGeoposition(latitude, longitude);
            setCoord(data);
            setLoader(false);
        } catch (error) {
            console.log(error);
        }
    }
    useEffect(() => {
        console.log(latitude, longitude)
        if (latitude && longitude) {
            getCoords();
        }


    }, [latitude, longitude]);

    useEffect(() => {
        console.log(coord);
    }, [coord]);


    const refresh = () => {
        getCoords();
    }
    return (
        <View style={styles.container}>
            <Text style={styles.text}>Vous êtes :</Text>
            {
                loader ? (
                    <ActivityIndicator size={'large'} />
                ) : (
                    <View>
                        <Text style={styles.text}>Pays : {coord.Country.LocalizedName}</Text>
                        <Text style={styles.text}>Ville : {coord.LocalizedName}</Text>
                    </View>
                )
            }
            <Pressable onPress={refresh} style={({pressed}) => [styles.button, (pressed) && styles.buttonPress]}>
                <Text style={styles.textButton}>Actualiser</Text>
            </Pressable>
        </View>
    )
}

export default App

const styles = StyleSheet.create({
    container: {
        flex:1,
        justifyContent: 'center',
        alignItems: 'center'
    },
    button: {
        marginVertical: 5,
        width: 100,
        height: 30,
        alignItems: 'center',
        justifyContent: 'center',
        backgroundColor: 'blue'
    },
    buttonPress:{
        backgroundColor: 'grey'
    },
    text:{
        marginVertical: 5,
        fontSize: 25
    },
    textButton: {
        color: 'white',
        fontSize: 15
    }
})