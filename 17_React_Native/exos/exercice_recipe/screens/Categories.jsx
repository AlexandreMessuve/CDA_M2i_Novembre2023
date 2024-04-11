import { FlatList, Pressable, StyleSheet, Text, View } from 'react-native'
import React, { useEffect, useContext } from 'react'
import { CATEGORIES } from '../data/data'
import Button from '../components/Button'
import favoriteContext from '../context/favoriteContext'
const Categories = ({ navigation }) => {
    const {favoriteList} = useContext(favoriteContext)
    useEffect(() => {
        console.log(CATEGORIES);
    })
    return (
        <View>
            <Button title={`Mes favoris ${favoriteList.length}`}  />
            <FlatList
                data={CATEGORIES}
                renderItem={({ item }) => {
                    const styles = StyleSheet.create({
                        container: {
                                backgroundColor: item.color,
                                width: 180,
                                height: 180,
                                alignItems: 'center',
                                justifyContent: 'center',
                                margin: 20,
                                shadowColor: 'black',
                                elevation: 5,
                                borderRadius: 10,
                                
                            },
                        text: {
                            color: 'black',
                            fontSize: 20,
                            fontWeight: 'bold'
                        }
                    })
                    return (
                        <Button title={item.title} styles={styles} onPress={() => navigation.navigate('Meals', {categorie: item})} />
                    )
                }}
                keyExtractor={(item) => item.id}
                numColumns={2}
            />        
        </View>
    )
}

export default Categories