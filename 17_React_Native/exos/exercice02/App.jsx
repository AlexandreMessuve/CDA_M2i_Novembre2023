import { StyleSheet, View, Button, FlatList, Text, TextInput } from 'react-native'
import React, { useEffect, useState } from 'react'
import FormArticle from './components/FormArticle';
import ArticleItem from './components/ArticleItem';
export default App = () => {
    const [courseList, setCourseList] = useState([{ "id": 1710232074582, "name": "Pain" }]);
    const [modal, setModal] = useState(false);
    const addArticle = (article) => {
        const newArticle = {
            id: Date.now(),
            name: article
        }
        setCourseList([...courseList, newArticle]);
        closeModal();
    }
    const showModal = () => {
        setModal(true);
    }
    const closeModal = () => {
        setModal(false);
    }
    const deleteItem = (id) => {
        const newCourseList = courseList.filter((article) => article.id !== id);
        setCourseList(newCourseList);
    }
    useEffect(() => {
        console.log(courseList);
    }, [courseList])
    return (
        <View style={styles.view}>
            <View>
                <Text style={styles.title}>Exercice02</Text>
            </View>
            <Text style={styles.subTitle}>Ma liste de course :</Text>
            {
                courseList.length === 0 && (
                    <Text style={styles.text}>Aucun article dans la liste</Text>
                )
            }
            <FlatList
                data={courseList}
                renderItem={(courseList) => {
                    return (
                        <ArticleItem index={courseList.index} article={courseList.item} />
                    )
                }}
                keyExtractor={(item) => item.id.toString()}
            />
            <View>
                <Button title={'Ajouter un article'} onPress={showModal} />
            </View>
            <FormArticle visible={modal} closeModal={closeModal} addArticle={addArticle} />
        </View>
    )
}

const styles = StyleSheet.create({

    view: {
        flex: 1,
        alignItems: 'center'
    },
    title: {
        fontSize: 30,
        fontWeight: '800',
        marginBottom: 30

    },
    text: {
        fontSize: 20
    },
    subTitle: {
        fontSize: 25,
        fontWeight: 'bold',
        marginBottom: 30
    },

});
