import { ImageBackground, Pressable, StyleSheet, Text, View } from 'react-native'
import React, { useContext} from 'react'
import favoriteContext from '../context/favoriteContext'
import Icon from 'react-native-vector-icons/AntDesign'
const MealCard = ({ meal, navigation }) => {
    const {favoriteList, addToFavorite, removeFavorite} = useContext(favoriteContext);
    const currentFavorite = favoriteList.find((fav) => fav.id === meal.id);
    const handleFavorite = () => {
        if(currentFavorite?.isFavorite){
            removeFavorite(meal.id);
        }else{
            addToFavorite(meal)
        }
    }
    return (
        <View style={styles.container}>
            <Pressable onPress={() => navigation.navigate('MealDetail', {meal: meal})}>
                <Pressable onPress={handleFavorite} style={styles.favoriteIcon}>
                        <Icon name={currentFavorite?.isFavorite ? 'heart' : 'hearto'} color={'red'} size={25} />
                </Pressable>
                <ImageBackground source={{ uri: meal.imageUrl }} style={styles.img} alt={meal.title} />
                <View style={styles.textView}>
                    <Text style={styles.textTitle}>{meal.title}</Text>
                    <Text style={styles.text}>{meal.duration} {meal.complexity.toUpperCase()} {meal.affordability.toUpperCase()}</Text>
                </View>
            </Pressable>
        </View>

    )
}

export default MealCard

const styles = StyleSheet.create({
    container: {
        elevation: 10,
        shadowColor: 'black',
        borderWidth: 1,
        borderRadius: 20,
        borderColor: 'grey',
        width: 400,
        marginVertical: 30,
        overflow: 'hidden',
        backgroundColor: 'white',
    },
    img: {
        width: 400,
        height: 200
    },
    textView: {
        width: 400,
        alignItems: 'center',

    },
    textTitle: {
        marginTop: 10,
        fontSize: 18,
        fontWeight: '800'
    },
    text: {
        marginVertical: 10
    },
    favoriteIcon: {
        position: 'absolute',
        right: 5,
        top: 210,
        zIndex: 4
    }
})